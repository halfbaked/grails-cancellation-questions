package org.grails.plugin.cancellationQuestions

class CancellationQuestionsTagLib {

  static namespace = "cancellationQuestions"

  // Used to display the common button of Add X + the download options in a dropdown menu
  // Is possible to specify and alternative to the Add button with the action attribute
  // Also it is possible to specify other actions in the dropdown via the body of the tag
  def addOrDownload = { attrs, body ->
    out << """
      <div class="btn-group pull-right">
    """
    if (attrs.action) {
      out << """
      ${g.link(action:attrs.action, params: attrs.params, class:'btn btn-primary') { attrs.title } }
      <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
        <span class="icon-chevron-down"></span>
      </a>
      """
    } else {
      out << """
      <a class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
        Download <span class="icon-chevron-down"></span>
      </a>
      """
    }
    out << """
            <ul class="dropdown-menu">
              <li data-value="csv" onClick="exportReport('csv');"><a href="#">Download as CSV</a></li>
              <li data-value="excel" onClick="exportReport('excel');"><a href="#">Download as Excel</a></li>
              <li data-value="pdf" onClick="exportReport('pdf');"><a href="#">Download as PDF</a></li>
    """
    if (body) {
      out << '<li class="divider"></li>'
      out << body()
    }
    out << """
            </ul>
      </div>  
       <script>
        function exportReport(format) {
          document.getElementById('formatInput').value = format;
          submitform();
          document.getElementById('formatInput').value = '';
        }
        function submitform() {
            document.forms['filters'].submit();
        }
      </script>   
    """
  }

  def ask  = { attrs, body ->
    def cancellationQuestions = CancellationQuestion.list()
    out << render(template: "/cancellationQuestionsTagLib/ask", model: [cancellationQuestions:cancellationQuestions, accountName:attrs.accountName, accountEmail: attrs.accountEmail, cancelUrl: attrs.cancelUrl])
  }

}
