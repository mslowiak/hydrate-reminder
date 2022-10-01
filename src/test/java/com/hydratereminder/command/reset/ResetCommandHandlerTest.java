package com.hydratereminder.command.reset;

import com.hydratereminder.HydrateReminderPlugin;
import com.hydratereminder.chat.ChatMessageSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ResetCommandHandlerTest {

    @Mock
    private ChatMessageSender chatMessageSender;
    @Mock
    private HydrateReminderPlugin hydrateReminderPlugin;
    @InjectMocks
    private ResetCommandHandler resetCommandHandler;

    @Test
    public void shouldResetHydrate() {
        resetCommandHandler.handle();

        final String resetString = "Hydrate reminder interval has been successfully reset.";

        verify(hydrateReminderPlugin, times(1)).setLastHydrateInstant(any());
        verify(hydrateReminderPlugin, times(1)).setResetState(true);
        verify(chatMessageSender, times(1)).sendHydrateEmojiChatGameMessage(resetString);

    }

}