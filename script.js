document.querySelector('form').addEventListener("submit", (e) => {
    e.preventDefault();
    let a = e.target.querySelector('#Attendance').value;
    console.log(a);
    let b = e.target.querySelector('#total_lectures').value;
    console.log(b);
    let c = e.target.querySelector('#absent_lectures').value;
    console.log(c);
    document.querySelector('#output1').innerHTML = Math.ceil(c/(1-a/100))-b;
    document.querySelector('#output2').innerHTML = Math.ceil(((c/(1-a/100))-b)/8);
})