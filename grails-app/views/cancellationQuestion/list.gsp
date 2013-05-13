<!DOCTYPE html>
<html>
  <head>
    <meta name="layout" content="admin">
  </head>
  <body>
    <div class="block">
      <div class="row-fluid">
        <div class="span12">
          <header class="group">
            <h1 class="pull-left"><i class="icon-envelope"></i> Cancellation Questions (${cancellationQuestions.size()})</h1>           
          </header>
        </div>
      </div>
      <div class="row-fluid">
        <div class="filters span1">
          <g:form action="list" name="filters">
            <input id="formatInput" type="hidden" name="format" value="" />
          </g:form>
        </div> 
        <div class="span10">
          <cancellationQuestions:addOrDownload action="add" title="Add" />
          <table class="results table table-bordered">
            <thead>
              <tr>
                <th>Title</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
            <g:each in="${cancellationQuestions}" var="cancellationQuestion">
            <tr>
              <td><g:link action="update" id="${cancellationQuestion.id}">${cancellationQuestion.title}</g:link></td>
              <td class="span2">
                <g:link action="update" id="${cancellationQuestion.id}">Edit</g:link>
                &nbsp;
                <g:link action="delete" id="${cancellationQuestion.id}" onclick="return confirm('are you sure?')">Delete</g:link>
              </td>
            </tr>
            </g:each>
            </tbody>
          </table>
        </div> <!-- end span -->
      </div> <!-- end fluid row -->
    </div> <!-- end block -->
  </body>
</html>
