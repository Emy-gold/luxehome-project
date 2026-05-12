package org.backendluxehome.modules.commun;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageResponse<T> {

    private List<T> content;
    private int number;
    private int size;
    private Long totalElements;
    private Long totalPages;
    private boolean first;
    private boolean last;
}
