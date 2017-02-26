package com.concrete.bruno.concretetest.ui.presenter.pullrequest;

import com.concrete.bruno.concretetest.model.PullRequest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by BRUNO on 23/02/2017.
 */

public class PullRequestPresenter implements PullRequestMvpPresenter {

    private PullRequestView pullRequestView;

    public PullRequestPresenter(PullRequestView pullRequestView){
        this.pullRequestView = pullRequestView;
    }

    @Override
    public void loadPullRequests() {
        List<PullRequest> pullRequests = new ArrayList<>();

        PullRequest pullRequest = new PullRequest();
        pullRequest.setTitle("Decouple BulkProcessor from client implementation");
        pullRequest.setBody("This commit modifies the `BulkProcessor` to be decoupled from the\\r\\nclient implementation. Instead it just takes a\\r\\n`BiConsumer<BulkRequest, ActionListener<BulkResponse>>` that executes\\r\\nthe `BulkRequest`. \\r\\n");
        pullRequest.setLogin("tbrooks8");
        pullRequest.setUrl("https://github.com/elastic/elasticsearch/pull/23373");

        pullRequests.add(pullRequest);

        pullRequest = new PullRequest();
        pullRequest.setTitle("Replace Painless's Cast with casting strategies");
        pullRequest.setBody("Replaces the `Cast` object which had 7 parameters with casting\\r\\nstrategy objects that ought to be much easier to read. The trouble\\r\\nwith the `Cast` object is that it is fairly difficult to figure\\r\\nout from reading the constructor invocation what the instructions\\r\\nare emitted for the cast. The casting strategies are much easier\\r\\nto read. Compare:\\r\\n```\\r\\n- return new Cast(LONG_TYPE, expected, true, LONG_TYPE, null, null, null);\\r\\n+ return new Cast.Unbox(LONG_TYPE, new Cast.Numeric(LONG_TYPE, expected));\\r\\n```\\r\\n\\r\\nThey both do the same thing but the bottom one can be read\\r\\n\\\"unbox into a `long` and then demote to the expected type\\\".\\r\\n\\r\\nOr compare:\\r\\n```\\r\\n- return new Cast(BOOLEAN_OBJ_TYPE, DEF_TYPE, explicit, null, null, BOOLEAN_TYPE, null);\\r\\n+ return new Cast.Box(BOOLEAN_TYPE);\\r\\n```\\r\\n\\r\\nBoth of them do the same thing but the bottom one reads\\r\\n\\\"box a boolean\\\" while the top one is kind of an eye chart.\\r\\n\\r\\n\\r\\nI reordered many of the `case` clauses so that they were\\r\\nin a consistent order: primitives (smallest to largest),\\r\\n`def`, `Object`, `Number`, boxed numbers (smallest to\\r\\nlargest). I tried to be consistent though I imagine I wasn't\\r\\nalways successful.\\r\\n\\r\\nI also added a ton of test cases for casting. There are four\\r\\nsorts of \\\"regular\\\" casts in painless, and I made sure to cover\\r\\nthem fairly extensively.\\r\\n\\r\\n* \\\"implicit non-internal\\\": Generally only works when promoting\\r\\nnumbers or widening types. For example, assigning the\\r\\n`int` `1` to `long`:\\r\\n```\\r\\nlong n = 1;\\r\\n```\\r\\n\\r\\n* \\\"implicit internal\\\": Like \\\"implicit, non-internal\\\" but also\\r\\nsupports boxing. Generally used for return values. For\\r\\nexample, a function returning an `Integer` can accept\\r\\nthe `int` `1`:\\r\\n```\\r\\nInteger foo() {return 1}\\r\\n```\\r\\n\\r\\n* \\\"explicit non-internal\\\": Fine for promoting or demoting\\r\\nnumbers and widening or narrowing types. For example,\\r\\nassigning the `long` `1` to an `int`:\\r\\n```\\r\\nlong l = 1L;\\r\\nint n = (int) l;\\r\\n```\\r\\n\\r\\n* \\\"explicit internal\\\": Fine for promoting or demoting\\r\\nnumbers, widening or narrowing types, and boxing.\\r\\nInterestingly, you can only trigger these in a foreach\\r\\nloop:\\r\\n```\\r\\nint[] array = new int[1]\\r\\narray[0] = 1\\r\\nfor (Short s : array) {   // see the demotion and boxing?!\\r\\n```\\r\\n\\r\\nI labeled this a `bug` because it fixes a few issues that I found while testing the \\\"explicit, internal\\\" casts.");
        pullRequest.setLogin("nik9000");
        pullRequest.setUrl("https://github.com/elastic/elasticsearch/pull/23369");

        pullRequests.add(pullRequest);

        pullRequestView.showListPullRequest(pullRequests);
    }
}
