package io.awallet.crypto.alphawallet.ui.widget.entity;

import io.awallet.crypto.alphawallet.entity.SalesOrder;
import io.awallet.crypto.alphawallet.entity.Token;
import io.awallet.crypto.alphawallet.ui.widget.holder.SalesOrderHeaderHolder;
import io.awallet.crypto.alphawallet.ui.widget.holder.OrderHolder;

/**
 * Created by James on 21/02/2018.
 */

public class SalesOrderSortedItem extends SortedItem<SalesOrder>
{
    public SalesOrderSortedItem(SalesOrder value, int weight)
    {
        super(OrderHolder.VIEW_TYPE, value, weight);
    }

    @Override
    public int compare(SortedItem other)
    {
        return weight - other.weight;
    }

    @Override
    public boolean areContentsTheSame(SortedItem newItem)
    {
        return newItem.viewType == viewType
                || (((SalesOrderSortedItem) newItem).value.contractAddress == value.contractAddress)
                && ((SalesOrderSortedItem) newItem).value.signature.hashCode() == value.signature.hashCode();
    }

    @Override
    public boolean areItemsTheSame(SortedItem other)
    {
        return other.viewType == viewType;
    }
}