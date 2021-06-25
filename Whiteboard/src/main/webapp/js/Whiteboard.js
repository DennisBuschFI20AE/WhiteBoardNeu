//Userdata
var username = "Dennis";
var userColor = "red";

//Canvas
var canvas;
var ctx;

//drawStyle
var thickness 	= 5;
var color		= "black";
var drawObject	= "point";

//menu
var img = new Image();

//#######################classes################################
class MenuField{
	
	constructor(x,y){
		this.pt = new Point(x, y);
	}
}

class Point{
	constructor(x, y){
		this.x = x;
		this.y = y;
	}
}

Point.prototype.drawPointer = function(){
	ctx.save();
	ctx.fillStyle = userColor;
	ctx.beginPath();
	ctx.arc(this.x, this.y, 5, 0, 2*Math.PI);
	ctx.fillText(username);
	ctx.stroke();
	ctx.restore();
}

//Temp
var mouseClicked = false;
var startPos	= new Point(0, 0);

//##########################ONLOAD#############################

window.onload = ()=>{
	canvas = document.getElementById("cvs");
	ctx	   = canvas.getContext("2d");
	width  = canvas.width;
	height = canvas.height;
	
	onmousedown = (evt)=>{
		mouseClicked = true;
	};
	
	onclick = (evt)=>{
		startPos.x = evt.offsetX;
		startPos.y = evt.offsetY;
	};
	
	onmouseup = (evt)=>{
		mouseClicked = false;
	};
	
	onmousemove = (evt)=>{
		let pos = new Point(evt.offsetX, evt.offsetY);
		pos.drawPointer();
		if( mouseClicked ){
				draw(drawObject, pt);
		}
	}
}

img.onload = ()=>{
	
};

//####################DRAW FUNCTIONS##########################

function draw(drawObject, pt){
	
	ctx.save();
	ctx.fillStyle = color;
	
	switch(drawObject){
		case "point":
			drawPoint(pt);
			break;
		case "circle":
			drawCircle(pt);
			break;
		case "line":
			drawLine(pt);
			break;
		case "rect":
			drawRect(pt);
			break;
		case "erase":
			erase(pt);
			break;
	}
	
	drawMenu();
	ctx.restore();
}

function drawPoint(pt){
	ctx.fillRect(pt.x, pt.y, thickness, thickness);
}

function drawCircle(pt){
	ctx.arc(startPos.x, startPos.y, Math.sqrt( Math.pow( Math.abs(pt.x - startPos.x),2) + Math.pow( Math.abs(pt.y - startPos.y),2) ) , 0 , Math.PI * 2  );
	ctx.stroke();
}

function drawLine(pt){
	
}

function drawRect(pt){
	
}

function erase(pt){
	
}

//MENU

function drawMenu(){
	
	ctx.fillstyle = "white";
	for( let i = 0; i < 10; i++){
		ctx.fillRect(width - 50, i * ( height / 10), 50 , (height/10) );
	}
	
	ctx.fillstyle = "black";
	ctx.fillRect( )
	
}


