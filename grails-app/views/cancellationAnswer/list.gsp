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
            <h1 class="pull-left"><i class="icon-envelope"></i> Cancellation Answers (${cancellationAnswers.size()})</h1>           
          </header>
        </div>
      </div>
      <div class="row-fluid">

        <div class="filters span3">

          <g:form action="list" name="filters">
            <input id="formatInput" type="hidden" name="format" value="" />
            <input placeholder="accountName" type="text" name="accountName" value="${params?.accountName}" />
            <input placeholder="accountName" type="text" name="accountEmail" value="${params?.accountEmail}" />
            <input placeholder="title" type="text" name="title" value="${params?.title}" />
            <input type="submit" value="Filter" class="btn" />
          </g:form>
        </div>
 
        <div class="span8">
          <cancellationQuestions:addOrDownload action="add" title="Add" />
          <table class="results table table-bordered">
            <thead>
              <tr>
                <th>Title</th>
                <th>Account Name</th>
                <th>Account Email</th>
                <th></th>
              </tr>
            </thead>
            <tbody>
            <g:each in="${cancellationAnswers}" var="cancellationAnswer">
            <tr>
              <td><g:link action="update" id="${cancellationAnswer.id}">${cancellationAnswer.title}</g:link></td>
              <td>${cancellationAnswer.accountName}</td>
              <td>${cancellationAnswer.accountEmail}</td>
              <td class="span2">
                <g:link action="update" id="${cancellationAnswer.id}">Edit</g:link>
                &nbsp;
                <g:link action="delete" id="${cancellationAnswer.id}" onclick="return confirm('are you sure?')">Delete</g:link>
              </td>
            </tr>
            </g:each>
            </tbody>
          </table>
          <div class="pull-right">
            <g:paginate controller="cancellationAnswer" action="list" total="${cancellationAnswers.totalCount}" max="30" maxsteps="5" params="${params}"/>
          </div>
        </div> <!-- end span -->
      </div> <!-- end fluid row -->
    </div> <!-- end block -->
  </body>
</html>
