/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.song.model.Song;
import com.example.song.service.*;
import java.util.*;

@RestController
public class SongController{
    
    @Autowired
    public SongJpaService songService;

    @GetMapping("/songs")
    public ArrayList<Song> getAllSongs(){
        return songService.getAllSongs();
    }

    @GetMapping("/songs/{songId}")
    public Song getSong(@PathVariable int songId){
        return songService.getSong(songId);
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song song){
        return songService.addSong(song);
    }

    @PutMapping("/songs/{songId}")
    public Song updateSong(@PathVariable int songId, @RequestBody Song song){
        return songService.updateSong(songId,song);
    }

    @DeleteMapping("/songs/{songId}")
    public ArrayList<Song> deleteSong(@PathVariable int songId){
       return songService.deleteSong(songId);
    }

}