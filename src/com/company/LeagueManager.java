package com.company;

import java.io.IOException;

public interface LeagueManager {

    void createFC() throws IOException;
    void deleteFC() throws IOException;
    void viewStatistics() throws IOException;
    void viewPLTableNew() throws IOException;
    void addPlayedMatch() throws IOException;
    void saveFile() throws IOException;
}