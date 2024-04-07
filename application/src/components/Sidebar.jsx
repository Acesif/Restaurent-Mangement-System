export const Sidebar = ({menu}) => {
    console.log(window.location.href)
    return (
        <div className="sidebar">
            <ul>
                {
                    menu.map((item,i)=> (

                        <a
                            href={item.link}
                            key={i}
                        >
                            {window.location.href === item.link? <strong>{item.name}</strong> : <p>{item.name}</p>}
                        </a>
                    ))
                }
            </ul>
        </div>
    )
}