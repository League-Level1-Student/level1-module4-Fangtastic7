int x = 50;
int y = 50;
int birdYVelocity = -100;
int gravity = 2;
int pipex = 500;
int pipex2 = 300; 
int upperPipeHeight = (int) random(100, 400);
int lowerY =  0 + upperPipeHeight + 100;
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
  rect(pipex2, lowerY, 60, upperPipeHeight);
  if (pipex==0) {
    teleportPipes();
    upperPipeHeight = (int) random(100, 400);
  }
  else if(pipex2==0){
    pipex2=500;
     upperPipeHeight = (int) random(100, 400);
  }
  else if(x==0){
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
  void mousePressed()
{
  gravity =0;
  y = y+ birdYVelocity;
  gravity = 5;
}
void teleportPipes()
{
  state = false;
  pipex = 500;
  state = true;
}
void setup()
{
  
  teleportPipes();
  size(500, 500);
}