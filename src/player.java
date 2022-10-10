import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
public class player  extends Application
{

    public static  void main(){
        launch();
    }
static dj obj;

    static {
        obj = new dj();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // TODO Auto-generated method stub
        //Initialising path of the media file, replace this with your file path
//    String path = "http://sample.vodobox.net/skate_phantom_flex_4k/skate_phantom_flex_4k.m3u8";
            String path=obj.getvideurl();
            System.out.println(path);
        //Instantiating Media class
//        Media media = new Media(new File(path).toURI().toString());
        Media media = new Media(path);
        //Instantiating MediaPlayer class
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        //Instantiating MediaView class
        MediaView mediaView = new MediaView(mediaPlayer);

        //by setting this property to true, the Video will be played
        mediaPlayer.setAutoPlay(true);

        //setting group and scene
        Group root = new Group();
        root.getChildren().add(mediaView);
        Scene scene = new Scene(root,500,400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Playing video");
        primaryStage.show();
    }

    }

