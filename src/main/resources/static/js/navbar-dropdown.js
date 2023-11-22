// Make Dropdown Submenus possible
$('.dropdown-submenu a.dropdown-submenu-toggle').on("click", function(e){
    $('.dropdown-submenu ul').removeAttr('style');
    $(this).next('ul').toggle();
    e.stopPropagation();
    e.preventDefault();
});
// Clear Submenu Dropdowns on hidden event
$('#bs-navbar-collapse-1').on('hidden.bs.dropdown', function () {
    $('.navbar-nav .dropdown-submenu ul.dropdown-menu').removeAttr('style');
});


// Make Dropdown Submenus possible
$( document ).ready(function() {

    // Make Secondary Dropdown on Click
    $('.dropdown-submenu a.dropdown-submenu-toggle').on("click", function(e){
        $('.dropdown-submenu ul').removeAttr('style');
        $(this).next('ul').toggle();
        e.stopPropagation();
        e.preventDefault();
    });

    // Make Secondary Dropdown on Hover
    $('.dropdown-submenu a.dropdown-submenu-toggle').hover(function(){
        $('.dropdown-submenu ul').removeAttr('style');
        $(this).next('ul').toggle();
    });

    // Make Regular Dropdowns work on Hover too
    $('.dropdown a.dropdown-toggle').hover(function(){
        $('.navbar-nav .dropdown').removeClass('open');
        $(this).parent().addClass('open');
    });

    // Clear secondary dropdowns on.Hidden
    $('#bs-navbar-collapse-1').on('hidden.bs.dropdown', function () {
        $('.navbar-nav .dropdown-submenu ul.dropdown-menu').removeAttr('style');
    });

});