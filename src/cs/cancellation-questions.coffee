 
(($) ->

  titleClickHandler = (event) ->
    $(".cancellation-question-bodies:visible").slideUp()
    $(".cancellation-question-body").hide()
    bodyId = $(this).data("bodyid")
    $body = $("#"+bodyId).show()
    $(".cancellation-question-bodies").slideDown()    
  $('.cancellation-question-title').click(titleClickHandler)

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
  $('.submit-cancellation-answer').click(submitAnswer)

  handleSubmitAnswerSuccess = (resp) ->
    if $("#askCancellationQuestions input[name=confirmCancel]").is(":checked")
      window.location = window.cancellationQuestions.cancelUrl
    else 
      $("#askCancellationQuestions").hide()
      $(".cancellation-confirmation").show()

  handleSubmitAnswerError = (err) ->    
    alert("Error submitting answer. #{err}")
  
)(jQuery)
