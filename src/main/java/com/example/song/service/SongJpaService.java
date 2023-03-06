/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here

package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.song.model.*;
//import com.example.song.controller.*;
import com.example.song.repository.SongJpaRepository;
import com.example.song.repository.SongRepository;

@Service
public class SongJpaService implements SongRepository{

    @Autowired
    private SongJpaRepository songJpaRepository;

    public ArrayList<Song> getAllSongs(){
        List<Song> arrLis = songJpaRepository.findAll();
        ArrayList<Song> songs = new ArrayList<>(arrLis);
        return songs;
    }

    public Song getSong(int songId){
        try{
            Song song = songJpaRepository.findById(songId).get();
            return song;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public Song addSong(Song song){
        Song addsong = songJpaRepository.save(song);
        //return getSong(addsong.getSongId());
        return addsong;
        
        
    }

    public Song updateSong(int songId, Song song){
        try{
            Song songNew = songJpaRepository.findById(songId).get();
            if(song.getSongName() != null){
                songNew.setSongName(song.getSongName());
            }
            if(song.getLyricist() != null){
                songNew.setLyricist(song.getLyricist());
            }
            if(song.getSinger() != null){
                songNew.setSinger(song.getSinger());
            }
            if(song.getMusicDirector() != null){
                songNew.setMusicDirector(song.getMusicDirector());
            }
            songJpaRepository.save(songNew);
            return songNew;
            }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    public ArrayList<Song> deleteSong(int songId){
        try{
            Song songNew = songJpaRepository.findById(songId).get();
            if(songNew.getSongId() == 0 ){
                throw new ResponseStatusException(HttpStatus.OK);
            }
            else{
                songJpaRepository.deleteById(songId);
            List<Song> arrLis = songJpaRepository.findAll();
            ArrayList<Song> songs = new ArrayList<>(arrLis);
            return songs;
            
            //throw new ResponseStatusException(HttpStatus.OK);

            }
            
            
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
            
        
    }

    
}


