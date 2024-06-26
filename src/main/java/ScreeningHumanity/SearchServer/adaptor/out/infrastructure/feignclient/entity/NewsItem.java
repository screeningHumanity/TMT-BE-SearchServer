package ScreeningHumanity.SearchServer.adaptor.out.infrastructure.feignclient.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewsItem {
    private String title;
    private String originallink;
    private String link;
    private String description;
    private String pubDate;
}
