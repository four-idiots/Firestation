function fetchfunc (para,part) {
    fetch (para).then (function (response) {
      response.text().then (function (text) {
        document.querySelector (part).innerHTML = text;
        console.log (para)
      });
    });
  }