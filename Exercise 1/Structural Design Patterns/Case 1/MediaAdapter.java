public class MediaAdapter implements MediaPlayer {
    private MP3Player mp3Player;
    private WAVPlayer wavPlayer;

    public MediaAdapter() {
        mp3Player = new MP3Player();
        wavPlayer = new WAVPlayer();
    }

    @Override
    public void play(String audioType, String fileName) {
        if (audioType.equalsIgnoreCase("mp3")) {
            mp3Player.playMP3(fileName);
        } else if (audioType.equalsIgnoreCase("wav")) {
            wavPlayer.playWAV(fileName);
        } else {
            System.out.println("Unsupported audio type: " + audioType);
        }
    }
}
