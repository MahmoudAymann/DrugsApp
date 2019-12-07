package maymanm.drugsapp.view.adapter.parent;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import maymanm.drugsapp.R;
import maymanm.drugsapp.model.chat.ChatItem;
import maymanm.drugsapp.view.adapter.itemviewmodel.ItemChatViewModel;
import maymanm.drugsapp.view.adapter.viewholder.ChatLeftViewHolder;
import maymanm.drugsapp.view.adapter.viewholder.ChatRightViewHolder;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_USER = 1;
    private static final int TYPE_BOT = 2;
    private List<ChatItem> mDataList;
    private MutableLiveData<ChatItem> mutableLiveData;
    private ViewDataBinding binding;

    public ChatAdapter() {
        mutableLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<ChatItem> getMutableLiveData() {
        return mutableLiveData;
    }

    public void updateDataList(final List<ChatItem> packingCardItems) {
        if (mDataList == null) {
            mDataList = packingCardItems;
            notifyItemRangeInserted(0, packingCardItems.size());
        } else {
            DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mDataList.size();
                }

                @Override
                public int getNewListSize() {
                    return packingCardItems.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    ChatItem old = mDataList.get(oldItemPosition);
                    ChatItem packingCardItem = packingCardItems.get(newItemPosition);
                    return old.getId() == packingCardItem.getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    ChatItem old = mDataList.get(oldItemPosition);
                    ChatItem item = packingCardItems.get(newItemPosition);
                    return old.getId() == item.getId()
                            && Objects.equals(old.getMessage(), item.getMessage())
                            && old.getType() == item.getType();
                }
            });
            mDataList = packingCardItems;
            diffResult.dispatchUpdatesTo(this);
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        if (viewType == TYPE_USER) {
            binding = DataBindingUtil.inflate(layoutInflater, R.layout.item_chat_left_side_view
                    , parent, false);
            return new ChatLeftViewHolder(binding);
        }
        binding = DataBindingUtil.inflate(layoutInflater,
                R.layout.item_chat_right_side_view
                , parent, false);
        return new ChatRightViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemChatViewModel viewModel = new ItemChatViewModel(getCurrentItem(position));
        if (holder instanceof ChatRightViewHolder) {
            ((ChatRightViewHolder) holder).setViewModel(viewModel);
        } else {
            ((ChatLeftViewHolder) holder).setViewModel(viewModel);
        }
        viewModel.getMutableLiveData().observeForever(o -> {
        });
    }

    private ChatItem getCurrentItem(int pos) {
        return mDataList.get(pos);
    }


    @Override
    public int getItemCount() {
        return mDataList == null ? 0 : mDataList.size();
    }


    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position).getType() == TYPE_USER)
            return TYPE_USER;
        return TYPE_BOT;
    }

    public void addItem(String message) {
        ChatItem ChatItem = new ChatItem();
        ChatItem.setMessage(message);
        ChatItem.setType(1);
        if (mDataList == null) {
            mDataList = new ArrayList<>();
        }
        mDataList.add(ChatItem);
        notifyItemInserted(mDataList.size() - 1);
        notifyItemRangeChanged(mDataList.size() - 1, mDataList.size());
    }

    @Override
    public void onViewAttachedToWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewAttachedToWindow(holder);
        if (holder instanceof ChatRightViewHolder) {
            ((ChatRightViewHolder) holder).bind();
        } else
            ((ChatLeftViewHolder) holder).bind();
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull RecyclerView.ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        if (holder instanceof ChatRightViewHolder) {
            ((ChatRightViewHolder) holder).unbind();
        } else
            ((ChatLeftViewHolder) holder).unbind();
    }


}