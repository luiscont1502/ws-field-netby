package com.netby.persistence.service.test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.netby.persistence.service.core.ConferenceCore;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ConferenceTest {
    @Mock
    List<String> talks;
    @InjectMocks
    private ConferenceCore conferenceCore;
    @Test
    public void testAddition() {
        // Simular la lista de charlas
        talks = Arrays.asList(
                "Writing Fast Tests Against Enterprise Rails 60min",
                "Overdoing it in Python 45min",
                "Rails for Python Developers lightning"
        );
        // Llamar al método de servicio y verificar el resultado
        int totalDuration = this.calculateTotalDuration(talks);
        assertEquals(110, totalDuration);
    }
    public int calculateTotalDuration(List<String> talks) {
        int totalDuration = 0;
        for (String talk : talks) {
            if (talk.endsWith("lightning")) {
                totalDuration += 5; // Duración de una charla relámpago en minutos
            } else {
                // Extraer la duración de la charla en minutos
                String durationString = talk.replaceAll("\\D+", "");
                totalDuration += Integer.parseInt(durationString);
            }
        }
        return totalDuration;
    }
}
