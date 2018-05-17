Tutorial is [here](https://developer.atlassian.com/server/framework/atlassian-sdk/getting-started-with-active-objects/)

- every Active Objects interaction must happen within a transaction. You can do it [manually](https://developer.atlassian.com/server/framework/atlassian-sdk/getting-started-with-active-objects/#step-7-implement-some-methods), OR use a declarative alternative: the `@Transactional` annotation.
It will only work on interfaces, so we won’t be able to apply it on our servlet.
- to run: `atlas-run`
- access servlet at: *http://java.host:5990/refapp/plugins/servlet/todo/list*
- to run tests: `atlas-unit-test`