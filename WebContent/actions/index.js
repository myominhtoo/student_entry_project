let year = document.getElementById("year");

year.textContent = new Date().getFullYear();

let date = document.getElementById("date");
let data = new Date();
date.textContent = data.getFullYear()+"/"+data.getMonth()+"/"+data.getUTCDay();