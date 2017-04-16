package com.yellocode.dao.entity;


public class GroupEntity extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    private String groupName;

    public GroupEntity(){ super();}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        GroupEntity that = (GroupEntity) o;

        return !(groupName != null ? !groupName.equals(that.groupName) : that.groupName != null);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        return result;
    }
}
