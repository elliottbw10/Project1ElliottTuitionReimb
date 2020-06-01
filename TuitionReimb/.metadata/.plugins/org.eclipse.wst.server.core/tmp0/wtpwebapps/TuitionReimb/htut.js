window.onload = function(){
	console.log("in onload");
	document.getElementById("formGet").addEventListener("click",getForm,false);
	document.getElementById("tutFormSubmit").addEventListener("click",postForm,false);
	document.getElementById("AmtGet").addEventListener("click",getAmt,false);
}

function getForm(){
	console.log("in get");
	let formid = document.getElementById("formCheck").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log( "in ORSC" + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var fr = JSON.parse(xhr.responseText);
			loadForm(fr);
		}
	}
	
	xhr.open("GET", "http://localhost:8080/TuitionReimb/headForm?formid="+formid,true);
	xhr.send();
}

function loadForm(fr){
	document.getElementById("uName").innerHTML = fr.uName;
	document.getElementById("fName").innerHTML = fr.fName;
	document.getElementById("lName").innerHTML = fr.lName;
	document.getElementById("classType").innerHTML = fr.classType;
	document.getElementById("classCost").innerHTML = fr.classCost;
	document.getElementById("classGrade").innerHTML = fr.classGrade;
	document.getElementById("descript").innerHTML = fr.descript;
	var d=fr.classStart;
	var date = new Date(d).toLocaleDateString();
	document.getElementById("classStart").innerHTML = date;
	console.log(fr.classStart);
	console.log(date);
	document.getElementById("formNum").innerHTML = fr.formNum;
	document.getElementById("appCode1").innerHTML = fr.appCode1;
	document.getElementById("appCode2").innerHTML = fr.appCode2;
	document.getElementById("appCode3").innerHTML = fr.appCode3;
	document.getElementById("reason").innerHTML = fr.reason;
}

function jsonBuilder(){
    var elements = document.getElementById("trmsForm").elements;
    var obj = {};
    for(var i = 0; i<elements.length-1;i++){
        var item = elements.item(i);
        obj[item.name] = item.value;
        console.log(obj);
    }
    var json = JSON.stringify(obj);
    console.log(json);
    return json;
}

function postForm(){
    console.log("in postVG");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function(){
        console.log( "in iORSC" + xhr.readyState);
        if(xhr.readyState == 4 && xhr.status == 200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TuitionReimb/headForm",true);
    var payload = jsonBuilder();
    xhr.send(payload);
}

function getAmt(){
	console.log("in get");
	let Userid = document.getElementById("AmtCheck").value;
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function(){
		console.log( "in ORSC" + xhr.readyState);
		if(xhr.readyState == 4 && xhr.status == 200){
			var am = JSON.parse(xhr.responseText);
			loadAmt(am);
		}
	}
	
	xhr.open("GET", "http://localhost:8080/TuitionReimb/headAD?Userid="+Userid,true);
	xhr.send();
}

function loadAmt(am){
	document.getElementById("uName").innerHTML = am.amt;
	document.getElementById("amt").innerHTML = am.amt;
	
}