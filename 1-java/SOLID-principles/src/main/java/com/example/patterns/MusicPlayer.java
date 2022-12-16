package com.example.patterns;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Track {
    private String title;
    private int duration;

    public Track(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}

interface NextTrackStrategy {
    int compare(Track t1, Track t2);
}

class PlayList {
    private List<Track> tracks = new ArrayList<>();
    private int nextNumber = 0;

    public void addNewTrack(Track track) {
        tracks.add(track);
    }

    public void setNextTrackStrategy(NextTrackStrategy strategy) {
        Collections.sort(tracks, (t1, t2) -> strategy.compare(t1, t2));
    }

    public Track getNextTrack() {
        Track track = tracks.get(nextNumber);
        nextNumber = nextNumber + 1;
        return track;
    }
}


public class MusicPlayer {

    public static void main(String[] args) {

        PlayList playList = new PlayList();
        playList.addNewTrack(new Track("The Beatles", 4));
        playList.addNewTrack(new Track("Frogstrap", 8));
        playList.addNewTrack(new Track("The Shining", 2));

//
//         class SDTF implements NextTrackStrategy {
//            public int compare(Track t1, Track t2) {
//                return Integer.compare(t1.getDuration(), t2.getDuration());
//            }
//        }

        // Anonymous inner class
        NextTrackStrategy sdtf = new NextTrackStrategy() {
            public int compare(Track t1, Track t2) {
                return Integer.compare(t1.getDuration(), t2.getDuration());
            }
        };

//        playList.setNextTrackStrategy(sdtf);

//        playList.setNextTrackStrategy(new NextTrackStrategy() {
//            public int compare(Track t1, Track t2) {
//                return Integer.compare(t2.getDuration(),t1.getDuration());
//            }
//        });

        playList.setNextTrackStrategy(((t1, t2) -> Integer.compare(t1.getDuration(), t2.getDuration())));


        System.out.println(playList.getNextTrack());
        System.out.println(playList.getNextTrack());
        System.out.println(playList.getNextTrack());

    }
}
