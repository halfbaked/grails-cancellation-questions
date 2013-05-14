<form id="askCancellationQuestions" controller="cancellationQuestions" action="ask">
  <div class="ask-cancellation-questions">

    <div>
    <g:each in="${cancellationQuestions}">
      <div> <g:radio name="cancellationAnswer.title" data-bodyid="cancellationQuestionBody${it.id}" class="cancellation-question-title" value="${it.title}"/> <span>${it.title}</span> </div>
    </g:each>              
    </div>
    <hr />

    <div class="cancellation-question-bodies hide">
      <g:each in="${cancellationQuestions}">
        <div class="cancellation-question-body" id="cancellationQuestionBody${it.id}"> 
          ${it.body}
        </div>
      </g:each>
      <div>      
        <textarea style="width:100%;" class="cancellation-answer-body">
        </textarea>
        <div class="confirm-checkbox">
          <g:checkBox name="confirmCancel" />
          <g:message code="cancellationQuestions.stillCancelCheckbox.label" />        
        </div>
        <div>
        <btn class="submit-cancellation-answer btn"><g:message code="cancellationQuestions.submitBtn.label" /></btn>
        </div>
      </div>
    </div>

  </div>
</form>
<div class="cancellation-confirmation hide">
  <g:message code="cancellationQuestions.cancellationConfirmation" />
</div>
<r:script>
  window.cancellationQuestions = {
    accountName: "${accountName}",
    accountEmail: "${accountEmail}",
    cancelUrl: "${cancelUrl}"
  }  
</r:script>
