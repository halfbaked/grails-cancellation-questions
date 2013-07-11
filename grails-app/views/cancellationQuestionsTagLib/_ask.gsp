<form id="askCancellationQuestions" controller="cancellationQuestions" action="ask" onsubmit="return false">
  <div class="ask-cancellation-questions">
    <div>
    <h4><g:message code="cancellationQuestions.answerSelection.title" /></h4>
    <g:each in="${cancellationQuestions}">
      <div class="cancellation-question-title"> <g:radio name="cancellationAnswer.title" data-bodyid="cancellationQuestionBody${it.id}" class="cancellation-question-title" value="${it.title}"/> <span>${it.title}</span> </div>
    </g:each>              
    </div>
    <div class="cancellation-question-bodies hide">
      <hr />
      <g:each in="${cancellationQuestions}">
        <div class="cancellation-question-body" id="cancellationQuestionBody${it.id}" style="margin:10px 0;"> 
          ${it.body}
        </div>
      </g:each>
      <div>             
        <textarea style="width:100%;" class="cancellation-answer-body"></textarea>
        <input id="confirmCancel" type="hidden" name="confirmCancel" value="no" />
        <div style="padding:5px;">
        <button class="submit-and-close btn btn-danger with-text ui-state-default ui-corner-all" style="display:inline-block;"><g:message code="cancellationQuestions.submitAndCloseBtn.label" /></button>
        <button class="submit-no-close btn with-text ui-state-default ui-corner-all" style="display:inline-block;"><g:message code="cancellationQuestions.submitNoCloseBtn.label" /></button>
        </div>
      </div>
    </div>
  </div>
</form>
<div class="cancellation-confirmation hide">
  <g:message code="cancellationQuestions.cancellationConfirmation" />
</div>
<script>
  window.cancellationQuestions = {
    accountName: "${accountName}",
    accountEmail: "${accountEmail}",
    cancelUrl: "${cancelUrl}"
  }  
</script>

