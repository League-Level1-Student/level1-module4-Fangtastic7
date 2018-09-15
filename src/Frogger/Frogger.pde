int x=50;
int y=50;
void draw(){
  background(0,0,255);
  fill(0,255,0);
  ellipse(x,y, 50,50);
  if(x>400){
    
  }
}
  void keyPressed()
{
  
      if(key == CODED){
            if(keyCode == UP)
            {
                  //Frog Y position goes 
                  y = y-10;
            }
            else if(keyCode == DOWN)
            {
                  //Frog Y position goes down 
                  y= y+10;
            }
            else if(keyCode == RIGHT)
            {
                  //Frog X position goes right
                  x=x+10;
            }
            else if(keyCode == LEFT)
            {
                  //Frog X position goes left
                  x= x-10;
            }
    
}
}
void setup(){
  size(400,400);
}