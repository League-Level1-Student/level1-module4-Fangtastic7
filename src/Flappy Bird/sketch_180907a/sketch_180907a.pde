int x = 50;
int y = 50;
int birdYVelocity = -30;
int gravity = 3;
int pipex = 600;
int pipex2 = 200; 
int upperPipeHeight = (int) random(100, 450);
int upperPipeHeight2 = (int) random(100,450);
int lowerY =  0 + upperPipeHeight + 150;
int boost = -5;
boolean state = true;
boolean endgame = false;
void draw() {
  
  lowerY =  0 + upperPipeHeight + 100;
  background(135, 206, 235);
  fill(255, 0, 0);
  stroke(0, 0, 255);
  ellipse( x, y, 25, 25);
  fill(0, 255, 0);
  rect(pipex, 0, 60, upperPipeHeight);
  fill(0, 255, 0);
  rect(pipex2, 350, 60, upperPipeHeight2);
  if (pipex==0) {
    teleportPipe();
    upperPipeHeight = (int) random(100, 400);
  }
  else if(pipex2==-60){
    teleportPipe2();
    pipex2=500;
     upperPipeHeight2 = (int) random(100, 400);
  }
  else if(x==-60){
    endgame();
  }
  else if(x==500){
    endgame();
  }
  else if (y < upperPipeHeight && x > pipex && x < (pipex+60)){
   endgame();
  }
  else if (y>lowerY && x > pipex2 && x < (pipex2+60)) {
    endgame();
  }
  pipex = pipex - 2;
  pipex2 = pipex2 -2;
  if(state==true){
  y = y +  gravity;
  }
}

void endgame(){
  
  text("Game Over",250, 250);
  stop();
  
}
void mousePressed(){
  gravity =0;
   y = y + birdYVelocity;
  if(birdYVelocity<70){
    birdYVelocity = birdYVelocity + boost;
 
 }
else if(birdYVelocity==-70){
    birdYVelocity = -5;
   
  }
  
  gravity = 3;
}
void teleportPipe()
{
 // state = false;
  pipex = 500;
 // state = true;
}
void teleportPipe2(){
  pipex2 = 500;
}
void setup()
{
  
  teleportPipe();
  size(500, 500);
}