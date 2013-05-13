<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="admin">
  </head>
  <body>
    <div class="row-fluid">
      <div class="span12">
        <ul class="breadcrumb">
          <li><g:link action="list">Cancellation Answers</g:link> <span class="divider">/</span></li>
          <li class="active">${cancellationAnswer.title}</li>
        </ul>
      </div>
    </div>
    <div class="block">
      <div class="row-fluid">
        <div class="span12">
          <header class="group" style="background:none;background-color:#333;color:#eee;"><h1 class="pull-left"><i class="icon-envelope"></i> ${cancellationAnswer.title}</h1></header>
        </div>
      </div>
      <div class="row-fluid">
        <div class="span12">
          <g:form name="cancellationAnswer" action="update" id="${cancellationAnswer.id}">
            <div class="form-content">
              <input value="${cancellationAnswer.id}" name="id" type="hidden" />
              <g:hasErrors bean="${cancellationAnswer}">
                <div class="errors"><g:renderErrors bean="${cancellationAnswer}" as="list" /></div>
              </g:hasErrors>
              <div>
                <label>Title</label>
                <input style="width:98%" type="text" name="title" value="${cancellationAnswer?.title}" />
              </div>
              <textarea name="title" style="width:98%">   
                 ${cancellationAnswer?.body}
              </textarea>
            </div>
            <div class="form-actions">
              <div class="pull-left">
                <g:submitButton name="submit" value="Save Changes" class="btn btn-primary"></g:submitButton>
                <g:link action="list" class="btn">Cancel</g:link>
              </div>
            </div>
          </g:form>
        </div> <!-- end span -->  
      </div> <!-- end row fluid -->
    </div> <!-- end block -->
  </body>
</html>
