package com.sln.cloud.domain;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchResult {
	String expand;
	long startAt;
	long maxResults;
	long total;
	Collection<MyIssue> issues;
	
	public String getExpand() {
		return expand;
	}
	public void setExpand(String expand) {
		this.expand = expand;
	}
	public long getStartAt() {
		return startAt;
	}
	public void setStartAt(long startAt) {
		this.startAt = startAt;
	}
	public long getMaxResults() {
		return maxResults;
	}
	public void setMaxResults(long maxResults) {
		this.maxResults = maxResults;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public Collection<MyIssue> getIssues() {
		return issues;
	}
	public void setIssues(Collection<MyIssue> issues) {
		this.issues = issues;
	}
	
	@Override
	public String toString() {
		return "SearchResult [expand=" + expand + ", startAt=" + startAt + ", maxResults=" + maxResults + ", total="
				+ total + ", issues=" + issues + "]";
	}
	
}
