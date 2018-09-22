int x=50;
int y=50;
int carspeed1 = 5;
Car car = new Car();

public class  Car {

  public void display(int carx, int cary, int sizewidth, int sizelength, int speed) {
    fill(0, 255, 0);
    rect(carx, cary, sizewidth, sizelength);
    for(carx=10; carx<400;carx++){
      carx = carx +carspeed1;
    }
    
  
}
}



void draw() {
  
  background(0, 0, 255);
  fill(0, 255, 0);
  ellipse(x, y, 50, 50);

  car.display(10, 10, 100, 50, 5);
  
}
void keyPressed()
{




  if (key == CODED) {
    if (keyCode == UP)
    {
      //Frog Y position goes 
      y = y-30;
    } else if (y<0) {

      y=0;
    } else if (keyCode == DOWN)
    {
      //Frog Y position goes down 
      y= y+30;
    } else if (y>400) {

      y=400;
    } else if (keyCode == RIGHT)
    {
      //Frog X position goes right
      x=x+30;
    }
    if (x>400) {
      x=400;
    } else if (keyCode == LEFT)
    {
      //Frog X position goes left
      x= x-30;
    } else if (x<0) {
      x=0;
    }
  }
}

void setup() {
  size(410, 410);
}