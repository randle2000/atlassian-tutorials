<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:mvc="http://www.springframework.org/schema/mvc"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

	<!-- Enables the Spring MVC @Controller programming model -->
	<mvc:annotation-driven />

	<!-- static mapping -->
	<!--
	<mvc:resources mapping="/resources/**" location="/resources/" />

	<bean id="messageSource" class="org.springframework.context.support.ResourceBundleMessageSource">
		<property name="basename">
			<value>validation</value>
		</property>
	</bean>	
	
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
		<property name="prefix" value="/WEB-INF/views/" />
		<property name="suffix" value=".jsp" />
	</bean>
	-->
	
</beans>