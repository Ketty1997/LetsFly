function myFunction() {
  document.querySelectorAll(".date").forEach((p) => dateInitializer(p));
}
function dateInitializer(block) {
  let today = new Date();

  let month = today.getMonth() + 1;
  let day = today.getDate();
  let year = today.getFullYear();
  if (month < 10) month = "0" + month.toString();
  if (day < 10) day = "0" + day.toString();
  let maxDate = year + "-" + month + "-" + day;

  block.valueAsDate = today;
  block.setAttribute("min", maxDate);
}
