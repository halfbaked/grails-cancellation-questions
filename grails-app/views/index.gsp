<!doctype html />
<html>
  <head>
    <r:require module="cancellationQuestions" />
    <r:layoutResources />
  </head>
  <body>
    <h1>A test page for testing the customer account facing UI</h1>
    <h2>It should not be included in the packaged plugin</h2>    
    <cancellationQuestions:ask action="cancel" controller="customer" accountName="Bob Hoskins, Bob Inc" accountEmail="bobhoskins@gmail.com" cancelUrl="http://www.google.ie" />
    <r:layoutResources />
  </body>
</html>
