package net.htlgkr.fuerederl21025.musicmanagment.dtos.incoming.put;

import org.springframework.lang.NonNull;

import java.util.List;

public record CategoryPutDto(@NonNull String name, @NonNull List<Integer> associatedTracks){
}
