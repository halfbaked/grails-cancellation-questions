(($) ->

  titleClickHandler = (event) ->
    $(".cancellation-question-bodies:visible").slideUp()
    $(".cancellation-question-body").hide()
    bodyId = $(this).data("bodyid")
    $body = $("#"+bodyId).show()
    $(".cancellation-question-bodies").slideDown()    
  $('.cancellation-question-title input[type="radio"]').click(titleClickHandler)

  submitAnswer = () ->    
    payload = {
      title: $("input.cancellation-question-title:checked").val()
      body: $(".cancellation-answer-body").val()
      accountName: window.cancellationQuestions.accountName
      accountEmail: window.cancellationQuestions.accountEmail
    }    
    $.ajax({
      type: 'POST'
      url: "/api/cancellationAnswer"
      data: JSON.stringify(payload)
      dataType: "json"
      contentType: "application/json"
      success: handleSubmitAnswerSuccess        
      error: handleSubmitAnswerError
    })

  submitAnswerAndClose = () ->
    $('#confirmCancel').val('yes')
    submitAnswer()

  handleSubmitAnswerSuccess = (resp) ->
    if ($("#askCancellationQuestions #confirmCancel").val() == 'yes')
      window.location = window.cancellationQuestions.cancelUrl
    else 
      $("#askCancellationQuestions").hide()
      $(".cancellation-confirmation").show()

  handleSubmitAnswerError = (err) ->
    alert("Error submitting answer. #{err}")

  $('#askCancellationQuestions .submit-no-close').click(submitAnswer)
  $('#askCancellationQuestions .submit-and-close').click(submitAnswerAndClose)
)(jQuery)
