<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="admin">
    <ckeditor:resources/>
  </head>
  <body>
    <div class="row-fluid">
      <div class="span12">
        <ul class="breadcrumb">
          <li><g:link action="list">Cancellation Questions</g:link> <span class="divider">/</span></li>
          <li class="active">${cancellationQuestion.title}</li>
        </ul>
      </div>
    </div>
    <div class="block">
      <div class="row-fluid">
        <div class="span12">
          <header class="group" style="background:none;background-color:#333;color:#eee;"><h1 class="pull-left"><i class="icon-envelope"></i> ${cancellationQuestion.title}</h1></header>
        </div>
      </div>
      <div class="row-fluid">
        <div class="span12">
          <g:form name="cancellationQuestion" action="update" id="${cancellationQuestion.id}">
            <div class="form-content">
              <input value="${cancellationQuestion.id}" name="id" type="hidden" />
              <g:hasErrors bean="${cancellationQuestion}">
                <div class="errors"><g:renderErrors bean="${cancellationQuestion}" as="list" /></div>
              </g:hasErrors>
              <div>
                <label>Title</label>
                <input style="width:98%" type="text" name="title" value="${cancellationQuestion?.title}" />
              </div>
              <ckeditor:config var="toolbar_CancellationQuestions">
              [
                { name: 'basic', items: [ 'Source' ] },
                { name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ], items: [ 'Bold', 'Italic', 'Underline', 'Strike', 'Subscript', 'Superscript', '-', 'RemoveFormat' ] },
                { name: 'links', items: [ 'Image', 'Link', 'Unlink' ] },
                { name: 'paragraph', items: [ 'NumberedList', 'BulletedList', 'Table', 'HorizontalRule'] },
                { name: 'styles', items: [ 'Styles', 'Format', 'TextColor' ] }
              ]
              </ckeditor:config>              
              <ckeditor:editor name="body" height="400px" width="98%" toolbar="CancellationQuestions" enterMode="CKEDITOR.ENTER_BR"><%= cancellationQuestion?.body %></ckeditor:editor>
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
