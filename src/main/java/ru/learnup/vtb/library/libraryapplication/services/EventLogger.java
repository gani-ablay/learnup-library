package ru.learnup.vtb.library.libraryapplication.services;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import ru.learnup.vtb.library.libraryapplication.events.SearchBookEvent;

@Component
public class EventLogger implements ApplicationListener<SearchBookEvent> {

    @Override
    public void onApplicationEvent(SearchBookEvent event) {
        final SearchBookEvent.Info info = (SearchBookEvent.Info) event.getSource();
        System.out.println("Осуществляется поиск книги " + info.getBookName());
    }
}
