public class App {
    public static void main(String[] args) {
        MediaPlayer player = new MediaAdapter();
        player.play("mp3", "song.mp3");
        player.play("wav", "track.wav");
    }
}
