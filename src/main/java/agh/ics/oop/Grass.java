package agh.ics.oop;

public class Grass extends AbstractWorldMapElement {

    public Grass(Vector2d position){
        this.position = position;
    }


    @Override
    public String toString() {
        return "*";
    }
    public String getImagePath(){
        return "grass";
    }
    public String getDesc(){
        return "Trawa";
    }
}
