package com.example.myandriodikpmdapplication.holders;

import com.example.myandriodikpmdapplication.models.File;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class FilesHolder {

    /**
     * An array of sample (dummy) items.
     */
    public static List<File> ITEMS = new ArrayList<File>();


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}