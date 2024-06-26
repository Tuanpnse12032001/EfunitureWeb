package converter;



import com.example.securityl.dtos.ReplyDto;
import com.example.securityl.exceptions.DataNotFoundException;
import com.example.securityl.models.Reply;

import java.util.List;
import java.util.stream.Collectors;

public class ReplyConverter {


    public static ReplyDto toDto(Reply reply) {
        return ReplyDto.builder()
                .id(reply.getId())
                .comment(reply.getComment())
                .userFullName(reply.getUserFullName())
                .level(reply.getLevel())
                .parentId(reply.getFeedback().getParentId())
                .createdAt(reply.getCreatedAt())
                .updatedAt(reply.getUpdatedAt())
                .parentId(reply.getFeedback().getParentId())
                .build();

    }

    public static Reply toEntity(ReplyDto replyDto) throws DataNotFoundException {
        return Reply.builder()
                .id(replyDto.getId())
                .level(replyDto.getLevel())
                .userFullName(replyDto.getUserFullName())
                .comment(replyDto.getComment())
                .build();
    }

    public static List<ReplyDto> toDtoList(List<Reply> replies) {
        return replies.stream()
                .map(ReplyConverter::toDto)
                .collect(Collectors.toList());
    }

}

