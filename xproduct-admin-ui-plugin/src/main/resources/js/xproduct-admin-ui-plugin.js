(function ($) { // this closure helps us keep our variables to ourselves.
// This pattern is known as an "iife" - immediately invoked function expression
 
    // form the URL
    var url = AJS.contextPath() + "/rest/xproduct-admin/1.0/";
 
    // wait for the DOM (i.e., document "skeleton") to load. This likely isn't necessary for the current case,
    // but may be helpful for AJAX that provides secondary content.
    $(document).ready(function() {
        // request the config information from the server
        $.ajax({
            url: url,
            dataType: "json"
        }).done(function(config) { // when the configuration is returned...
            // ...populate the form.
            $("#name").val(config.name);
            $("#time").val(config.time);
            
            // whenever the form is submitted, instead of the usual, default action of POSTing the form data,
            // our updateConfig() method is called and our updated configuration is submitted as a PUT request to the configuration resource.
            AJS.$("#admin").submit(function(e) {
                e.preventDefault();
                updateConfig();
            });
        });
    });

})(AJS.$ || jQuery);

function updateConfig() {
	  AJS.$.ajax({
	    url: AJS.contextPath() + "/rest/xproduct-admin/1.0/",
	    type: "PUT",
	    contentType: "application/json",
	    data: '{ "name": "' + AJS.$("#name").attr("value") + '", "time": ' +  AJS.$("#time").attr("value") + ' }',
	    processData: false
	  });
	}