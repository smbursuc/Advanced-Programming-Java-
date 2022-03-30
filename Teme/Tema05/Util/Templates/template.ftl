<html>
<head>
  <title>Report</title>
</head>
<body>
  <h1>${title}</h1>
  <ul>
    <#list catalogItems as item>
      <li>${item_index + 1}. ${item.identifier}, ${item.title}, ${item.location}</li>
    </#list>
  </ul>

</body>
</html>