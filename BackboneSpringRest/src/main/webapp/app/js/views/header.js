window.HeaderView = Backbone.View.extend({

    initialize: function() {
        this.template = _.template(tpl.get('header'));
    },

    render: function() {
        $(this.el).html(this.template());
        return this;
    },

    events: {
         "click .new"    : "newEmployee"
    },

    newEmployee: function() {
        app.navigate("employee/new", true);
        return false;
    }

});