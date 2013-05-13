<div>
  <g:each in="${cancellationQuestions}">
    <div> <g:radio name="cancellationAnswer.title" data-bodyid="cancellationQuestionBody${it.id}" class="cancellationQuestionTitle" /> <span>${it.title}</span> </div>
  </g:each>              
  </div>
  <div>
    <g:each in="${cancellationQuestions}">
      <div class="hide" id="cancellationQuestionBody${it.id}"> 
        ${it.body}
      </div>
    </g:each>
    <div class="hide">      
      <textarea style="width:100%;">
      </textarea>
      <div>
        <g:checkBox name="cancel" />
        <g:message code="cancellationQuestions.stillCancelCheckbox.label" />        
      <div>
      <g:submitButton value="Submit" />
    </div>
  </div>
</div>
