/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics;

import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author Riku
 */
public class QueryBuilder {
    
    protected Matcher matcher;

    public QueryBuilder() {
        this.matcher = new And();
    }

    public QueryBuilder hasAtLeast(int value, String field) {
        this.matcher = new And(matcher, new HasAtLeast(value, field));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String field) {
        this.matcher = new And(matcher, new HasFewerThan(value, field));
        return this;
    }

    public QueryBuilder playsIn(String team) {
        this.matcher = new And(matcher, new PlaysIn(team));
        return this;
    }

    public QueryBuilder not(Matcher matcher) {
        this.matcher = new Not(matcher);
        return this;
    }

    public QueryBuilder oneOf(Matcher... matchers) {
        this.matcher = new Or(matchers);
        return this;
    }

    public Matcher build() {
        Matcher createdMatcher = matcher;
        this.matcher = new And();
        return createdMatcher;
    }
}
