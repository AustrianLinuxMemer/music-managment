package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import java.util.List;

public record CategoryPutDto(String name, List<Integer> associatedTracks){
}
