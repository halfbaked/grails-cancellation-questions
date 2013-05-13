(($) ->
  titleClickHandler = (event) ->
    bodyId = $(this).data("bodyid")
    $body = $("#"+bodyId).removeClass('hide').addClass("howdy")
    console.log $body
    $body.removeClass()
    $body.removeClass("hide").addClass('post')
    $body.addClass("bingo")
    console.log $body.html()
    $body.css("border:1px solid blue")
    console.log document.getElementById(bodyId).className


  $('.cancellationQuestionTitle').click(titleClickHandler)
)(jQuery)
