package online.mrgutter.week10.model;

public class Movie {

    private String title;
    private int year;
    private String gener;
    private String imageFileName;

     public Movie(){

     }

     public Movie(String title, int year,String gener,String imageFileName){


         //error null error checking in constructor
         if(title!=null||title!="")
         {
         this.title=title;
         }else{
             this.title="Unknown";
         }

         if(correctYear(year))
         {
             this.year=year;
         }else{
             this.year=0;
         }

         if(gener!=null||gener!="")
         {
             this.gener=gener;
         }else{
             this.gener="Unknown";
         }

         if(imageFileName!=null||imageFileName!="")
         {
             this.imageFileName=imageFileName;
         }else{
             this.imageFileName="Unknown";
         }



     }

    private boolean correctYear(int year) {
         if (year>=0){
             return true;
         }
         else {
             return false;
         }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }


}
